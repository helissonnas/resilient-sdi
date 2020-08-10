class Feature(object):
    def __init__(self, id, name, service_url, service_id):
        self.id = id
        self.name = name
        self.service_url = service_url
        self.service_id = service_id

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {
            'id': self.id,
            'name': self.name,
            'service_url': self.service_url,
            'service_id': self.service_id,
        }
