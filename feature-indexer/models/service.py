class Service(object):
    def __init__(self, id, wfs_url, title, description, publisher, geometry, features):
        self.id = id
        self.wfs_url = wfs_url
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
            'wfs_url': self.wfs_url,
            'title': self.title,
            'description': self.description,
            'publisher': self.publisher,
            'geometry': self.geometry,
            'features': self.features,
        }
