class DescriptiveBody(object):
    def __init__(self, service, feature):
        self.f_title = feature.title
        self.s_title = service.title
        self.s_desc = service.description
        self.f_desc = feature.description
        self.s_pub = service.publisher

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {'f_title': self.f_title,
                's_title': self.s_title,
                's_desc': self.s_desc,
                'f_desc': self.f_desc,
                's_pub': self.s_pub,
                }
