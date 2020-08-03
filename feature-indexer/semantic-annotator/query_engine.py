import spotlight
from word_extractor import extract_feature_words, extract_service_words


def search(fd, stopwords, service, feature):
    query_string = extract_feature_words(
        fd, stopwords, service, feature, 2)

    result = annotate(query_string)

    if (result):
        return [result, query_string]
    else:
        query_string = extract_feature_words(
            fd, stopwords, service, feature, 1)

        result = [annotate(query_string), query_string]

        if (result):
            return result
        else:
            query_string = extract_service_words(
                fd, stopwords, service, feature)

            return [annotate(query_string), query_string]


def annotate(query_string):
    try:
        return spotlight.annotate(
            'http://model.dbpedia-spotlight.org/pt/annotate', query_string, confidence=0.0, support=0)
    except:
        return None
