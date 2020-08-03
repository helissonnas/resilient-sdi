import re
from nltk import tokenize
from descriptive_body import DescriptiveBody
from acronym import mach_acronym


def get_desc_words(descriptive_body, stopwords):
    desc_words = [
        w for w in tokenize.word_tokenize(descriptive_body, language='portuguese')
        if w not in '\'\'``!@#$%^&*()_-+={}[].,:'
        and re.match(r'[1-3][0-9]{3}', w) == None
        and re.match(r'[\d]', w) == None
    ]

    desc_words = [mach_acronym(w) for w in desc_words]

    return [w.lower()
            for w in desc_words if w not in stopwords]


def extract_feature_words(fd, stopwords, service, feature, level):
    descstr = DescriptiveBody(service, feature)

    freq = fd(get_desc_words(descstr.text_body(), stopwords))

    most_commom = map(
        lambda w: w[0], [f for f in freq.most_common() if f[1] >= level])

    return ' '.join(most_commom)


def extract_service_words(fd, stopwords, service, feature):
    descstr = DescriptiveBody(service, feature)

    freq = fd(get_desc_words(descstr.expanded_text_body(), stopwords))

    most_commom = map(
        lambda w: w[0], freq.most_common())

    return ' '.join(most_commom)
