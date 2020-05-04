class FeatureType(object):
    def __init__(self, id, title, name, description, keywords, service_id, geometry):
        self.id = id
        self.title = title
        self.name = name
        self.description = description
        self.keywords = keywords
        self.service_id = service_id
        self.geometry = geometry

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {
            'id': self.id,
            'title': self.title,
            'name': self.name,
            'description': self.description,
            'keywords': self.keywords,
            'service_id': self.service_id,
            'geometry': self.geometry,
        }
