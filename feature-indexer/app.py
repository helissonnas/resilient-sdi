import data_access
from flask import Flask, make_response, jsonify
import json

app = Flask(__name__)


@app.route('/service')
def get_services():
    all_services = data_access.find_all_services()
    return make_response(jsonify(services=all_services), 200)


@app.route('/feature')
def get_features():
    all_features = data_access.find_all_features()
    return make_response(jsonify(features=all_features), 200)


if __name__ == '__main__':
    app.run()
