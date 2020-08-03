class DescriptiveBody(object):
    def __init__(self, service, feature):
        self.f_title = feature['title']
        self.f_id = feature['id']
        self.s_id = service['id']
        self.s_title = service['title']
        self.s_desc = service['description']
        self.f_desc = feature['description']
        self.s_pub = service['publisher']
        self.f_name = feature['name']
        self.similars = []

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {
            'f_id': self.f_id,
            's_id': self.s_id,
            'f_title': self.f_title,
            's_title': self.s_title,
            's_desc': self.s_desc,
            'f_desc': self.f_desc,
            's_pub': self.s_pub,
            'similars': self.similars
        }

    def text_body(self):
        body = ""
        if (self.f_title):
            body += self.f_title

        if ((not self.f_title) and self.f_name):
            body += " " + self.f_name.replace("_", " ")

        if (self.f_desc):
            body += " " + self.f_desc.replace("_", " ")

        return body

    def expanded_text_body(self):
        body = ""
        if (self.f_title):
            body += self.f_title

        if (self.f_name):
            body += " " + self.f_name.replace("_", " ")

        if (self.f_desc):
            body += " " + self.f_desc.replace("_", " ")

        if (self.s_desc):
            body += " " + self.s_desc

        return body
