from sqlalchemy import create_engine
from models.service import Service
from models.feature_type import FeatureType


try:
    engine = create_engine(
        'postgresql://postgres:sapo1606@localhost:5432/inde_database')
except Exception as e:
    raise


def find_all_services():
    query = """
      SELECT id, url, type, title, description, publisher, geometry FROM service LIMIT 10; 
    """
    result = engine.execute(query).fetchall()
    list_all_services = []

    if len(result) > 0:
        for s in result:
            list_all_services.append(
                Service(s[0], s[1], s[2], s[3], s[4], s[5], s[6], find_feature_of_service(s[0])))

    return [s.serialize() for s in list_all_services]


def find_feature_of_service(service_id):
    query = """
      SELECT id, title, name, description, keywords, service_id, geometry FROM feature_type WHERE service_id = '""" + service_id + """' LIMIT 10; 
    """
    result = engine.execute(query).fetchall()

    list_all_features = []

    if len(result) > 0:
        for s in result:
            list_all_features.append(
                FeatureType(s[0], s[1], s[2], s[3], s[4], s[5], s[6]))

    return [s.serialize() for s in list_all_features]


def find_service(id):
    query = """
      SELECT id, url, type, title, description, publisher, geometry FROM service WHERE id = """ + id + """LIMIT 10; 
    """
    result = engine.execute(query).fetchall()

    service = None

    if len(result) > 0:
        for s in result:
            service = Service(s[0], s[1], s[2], s[3], s[4], s[5], s[6])

    return service.serialize()


def find_all_features():
    query = """
      SELECT id, title, name, description, keywords, service_id, geometry FROM feature_type LIMIT 10; 
    """
    result = engine.execute(query).fetchall()
    list_all_features = []

    if len(result) > 0:
        for s in result:
            list_all_features.append(
                FeatureType(s[0], s[1], s[2], s[3], s[4], s[5], s[6]))

    return [s.serialize() for s in list_all_features]
