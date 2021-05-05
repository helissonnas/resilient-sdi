from owslib.wms import WebMapService
import http.client
import json

connection = http.client.HTTPConnection('127.0.0.1:5000')


def get(resource):
    req = connection.request('GET', '/' + resource)
    resp = connection.getresponse()

    return resp.read()


def get_WMS(service):
    wms = WebMapService(service['url'], version='1.1.1')
    return list(wms.contents)


def get_services(id):
    return get('service/' + id)


def get_features():
    return get('features')


serviceResp = get_services('45868665-50d9-42df-8eb3-e6e0f288a0b5')

print(str(serviceResp))


connection.close()
