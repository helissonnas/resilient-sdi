from owslib.wms import WebMapService
import http.client
import json
from gensim.models import KeyedVectors
from descriptive_body import DescriptiveBody
from acronym import mach_acronym


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

model = KeyedVectors.load_word2vec_format('skip_s100.txt')

features = []

for service in serviceResp['services']:
    for feature in service['features']:
        features.append(DescriptiveBody(service, feature))

print("const result = [")


for fe in features:
    if (fe.f_title):
        similars = [{'f': '', 'ft': '', 's': 0},
                    {'f': '', 'ft': '', 's': 0},
                    {'f': '', 'ft': '', 's': 0}]
        for fo in features:
            if (fo.f_title):
                similarity = model.wmdistance(
                    [mach_acronym(w).lower() for w in fe.f_title.split()],
                    [mach_acronym(w).lower() for w in fo.f_title.split()]
                )

                i = 0
                match = False
                while (i < len(similars) and not match):
                    if (float("{:.4f}".format(similarity)) > similars[i]['s'] and similarity != float("inf")):
                        similars[i]['s'] = float("{:.4f}".format(similarity))
                        similars[i]['f'] = fo.f_id
                        similars[i]['ft'] = " ".join([
                            mach_acronym(w) for w in fo.text_body().split()
                        ])
                        match = True
                    i += 1

        fe.similars = similars

print([f.serialize() for f in features])


print("]")

connection.close()
