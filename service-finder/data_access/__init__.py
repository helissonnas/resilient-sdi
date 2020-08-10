from sqlalchemy import create_engine
from feature import Feature
from similarity import Similarity

try:
    engine = create_engine(
        'postgresql://finder_user:finder456788@localhost:5436/feature_db')
except Exception as e:
    raise


def find_feature(id):
    query = """
      SELECT
        id,
        name,
        service_url,
        service_id
      FROM
        features
      WHERE
        id = '""" + id + """';
    """
    result = engine.execute(query).fetchall()

    feature = None

    if len(result) > 0:
        for s in result:
            feature = Feature(s[0], s[1], s[2], s[3])

    return feature.serialize()


def find_most_similar(id):
    query = """
      SELECT id, sim_f_id, rank FROM similar_features WHERE id = '""" + id + """' AND rank = 1;
    """
    result = engine.execute(query).fetchall()

    sim = None

    if len(result) > 0:
        for s in result:
            sim = Similarity(s[0], s[1], s[2])

    return sim.serialize()


def find_similars(id):
    query = """
      SELECT id, sim_f_id, rank FROM similar_features WHERE id = '""" + id + """';
    """
    result = engine.execute(query).fetchall()
    list_all_services = []

    if len(result) > 0:
        for s in result:
            list_all_services.append(Similarity(s[0], s[1], s[2]))

    return [s.serialize() for s in list_all_services]
