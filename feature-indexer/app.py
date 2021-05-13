import data_access
from flask import Flask, make_response, jsonify
import json
import re

app = Flask(__name__)


@app.route('/service')
def get_services():
    all_services = data_access.find_all_services()
    return make_response(jsonify(services=all_services), 200)


@app.route('/service/<string:id>/')
def get_service(id):
    service = data_access.find_service(id)
    return make_response(jsonify(service=service), 200)


@app.route('/feature')
def get_features():
    all_features = data_access.find_all_features()
    return make_response(jsonify(features=all_features), 200)


@app.route('/feature/<string:id>/')
def get_feature(id):
    feature = data_access.find_feature(id)
    return make_response(jsonify(feature=feature), 200)


@app.route('/feature/<string:id>/url')
def get_feature_url(id):
    if (id == 'falt_id'):
        return 500
    feature = data_access.find_feature(id)
    service = data_access.find_service(feature['service_id'])

    url = service['wfs_url']
    url_re = re.sub(r'layers=[^&]*', 'layers='+feature['name'], url)
    url_concat = url_re + '&request=GetMap&srs=EPSG:4326&format=application/openlayers'
    print(url_concat)
    return make_response(url_concat, 200)


if __name__ == '__main__':
    app.run(host='0.0.0.0')
