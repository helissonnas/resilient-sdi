from owslib.wms import WebMapService
import http.client
import json
import nltk
from nltk import tokenize
from query_engine import search
from gensim.models import KeyedVectors


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


serviceResp = get_services()

nltk.download('stopwords')
nltk.download('punkt')
stopwords = nltk.corpus.stopwords.words('portuguese')

model = KeyedVectors.load_word2vec_format('skip_s100.txt')

print("const result = [")


for service in serviceResp['services']:
    for feature in service['features']:
        title = ""

        if (feature['title']):
            title = feature['title']
        elif (feature['name']):
            title = feature['name']

        results = search(nltk.FreqDist, stopwords, service, feature)
        annotations = results[0]

        print('{ query_string:\'' + results[1] + '\',')
        print(' feature_title:\'' + title + '\',')
        print(' serv_title:\'' + service['title'] + '\',')

        print("ann: ")
        print(annotations)
        print("},")
print("]")


connection.close()
