CREATE TABLE features (
  id text PRIMARY KEY,
  name text NOT NULL,
  service_url text NOT NULL,
  service_id text NOT NULL
);

CREATE TABLE similar_features (
  id text,
  sim_f_id text,
  rank int,
  FOREIGN KEY (id) REFERENCES features (id),
  FOREIGN KEY (sim_f_id) REFERENCES features (id)
);

INSERT INTO features
  VALUES ('8f72ee86-537f-4e95-9132-7ff286d99b42', 'MPOG:UBS', 'http://www.geoservicos.inde.gov.br/geoserver/wms?layers=MPOG%3APetroleo_Gas_Bacias_A3_M&width=1024&height=768&bbox=-74%2C-34%2C-29%2C6', '46bc41f1-7b08-4ef9-a195-5291f2b6403e');

INSERT INTO features
  VALUES ('1657c996-5f27-4a76-8df0-420779bc8b40', 'MPOG:UBS', 'http://www.geoservicos.inde.gov.br/geoserver/wms?layers=MPOG%3ACombustiveis_Refinaria&width=1024&height=768&bbox=-74%2C-34%2C-29%2C6', '55bf6357-bada-4b09-acf4-8a03d803de4e');

INSERT INTO similar_features
  VALUES ('8f72ee86-537f-4e95-9132-7ff286d99b42', '1657c996-5f27-4a76-8df0-420779bc8b40', 1);

INSERT INTO features
  VALUES ('708d1b9a-067a-4bca-9721-c07644cc07ef', 'BNDES:CNAES_por_Municipio_2012', 'http://www.geoservicos.inde.gov.br/geoserver/wms?layers=MPOG%3APrevencao_em_areas_de_risco&width=1024&height=768&bbox=-74%2C-34%2C-29%2C6', '2478abc1-0335-44ee-8291-f6d58464f47d');

INSERT INTO features
  VALUES ('08e0ed1e-0dcd-4b2d-b414-b0da99848485', 'BNDES:CNAES_por_Municipio_2012', 'http://www.geoservicos.inde.gov.br/geoserver/wms?layers=MPOG%3ATransporte_Ferroviario&width=1024&height=768&bbox=-74%2C-34%2C-29%2C6', 'dcee1454-44fa-4f01-b68f-3def22ac658b');

INSERT INTO similar_features
  VALUES ('708d1b9a-067a-4bca-9721-c07644cc07ef', '08e0ed1e-0dcd-4b2d-b414-b0da99848485', 1);

