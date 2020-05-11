from owslib.wms import WebMapService
import http.client
import json

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

for service in serviceResp['services']:
    print(service['title'])
    print(service['description'])
    print(service['publisher'] + '\n')

# Assunto


connection.close()
