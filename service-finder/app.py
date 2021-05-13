from flask import Flask, make_response

app = Flask(__name__)


@app.route('/similars/<string:id>')
def get_similars(id):
    return make_response('http://www.geoservicos.inde.gov.br/geoserver/wms?layers=BNDES:CNAES_por_Municipio_2011&width=1024&height=768&bbox=-74%2C-34%2C-29%2C6&request=GetMap&srs=EPSG:4326&format=application/openlayers', 200)


if __name__ == '__main__':
    app.run(host='0.0.0.0')
