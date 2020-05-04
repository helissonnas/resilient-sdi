class Service(object):
    def __init__(self, id, url, type, title, description, publisher, geometry, features):
        self.id = id
        self.url = url
        self.type = type
        self.title = title
        self.description = description
        self.publisher = publisher
        self.geometry = geometry
        self.features = features

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {
            'id': self.id,
            'url': self.url,
            'type': self.type,
            'title': self.title,
            'description': self.description,
            'publisher': self.publisher,
            'geometry': self.geometry,
            'features': self.features,
        }
