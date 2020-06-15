from owslib.wms import WebMapService
import http.client
import json
import nltk
from nltk import tokenize
import re
import spotlight

connection = http.client.HTTPConnection('127.0.0.1:5000')


def get(resource):
    req = connection.request('GET', '/' + resource)
    resp = connection.getresponse()

    return json.loads(resp.read())


def get_WMS(service):
    wms = WebMapService(service['url'], version='1.1.1')
    return list(wms.contents)


def get_services():
    return get('service')


def get_features():
    return get('features')


def relevantWords(fd):
    relevant_w = [0, 0, 0, 0, 0]
    relevant_f = [0, 0, 0, 0, 0]

    for word in list(fd.keys()):
        for i in range(5):
            if (fd[word] > relevant_f[i]):
                relevant_f[i] = fd[word]
                relevant_w[i] = word
                break

    return relevant_w


serviceResp = get_services()

nltk.download('stopwords')
nltk.download('punkt')
stopwords = nltk.corpus.stopwords.words('portuguese')

for service in serviceResp['services']:
    descstr = service['title'] + '\n' + \
        service['description'] + '\n' + service['publisher']

    # Split service description in word that arent symbols or years
    desc_words = [
        w for w in tokenize.word_tokenize(descstr, language='portuguese')
        if w not in '!@#$%^&*()_-+={}[].,:'
        and re.match(r'[1-3][0-9]{3}', w) == None
        and re.match(r'[\d]', w) == None
    ]

    # Get distribution frequency for word that arent stopwords
    fd = nltk.FreqDist(w.lower() for w in desc_words if w not in stopwords)

    print('\n\n -----' + service['title'] + ' most frequent words --------')
    print(relevantWords(fd))


connection.close()
