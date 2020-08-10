from flask import Flask, make_response, jsonify
import data_access
import json
import re

app = Flask(__name__)


@app.route('/feature/<string:id>/')
def get_feature(id):
    feature = data_access.find_feature(id)
    return make_response(jsonify(feature=feature), 200)


@app.route('/feature/<string:id>/url')
def get_feature_url(id):
    if (id == 'falt_id'):
        return 500
    feature = data_access.find_feature(id)

    url = feature['service_url']
    url_re = re.sub(r'layers=[^&]*', 'layers='+feature['name'], url)
    url_concat = url_re + '&request=GetMap&srs=EPSG:4326&format=application/openlayers'

    print(url_concat)

    return make_response(url_concat, 200)


@app.route('/feature/<string:id>/similar')
def get_similar(id):
    most_similar = data_access.find_most_similar(id)

    return make_response(jsonify(feature=most_similar), 200)


@app.route('/feature/<string:id>/similar/url')
def get_similar_url(id):
    feature = data_access.find_most_similar(id)

    return get_feature_url(feature['sim_f_id'])


if __name__ == '__main__':
    app.run(port=5050)
