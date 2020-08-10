class Similarity(object):
    def __init__(self, id, sim_f_id, rank):
        self.id = id
        self.sim_f_id = sim_f_id
        self.rank = rank

    def __str__(self):
        return self.__dict__

    def __repr__(self):
        return self

    def serialize(self):
        return {
            'id': self.id,
            'sim_f_id': self.sim_f_id,
            'rank': self.rank,
        }
