FROM python:3

WORKDIR /server

COPY . .

RUN pip3 install --no-cache-dir -r requirements.txt

ENTRYPOINT ["python"]

CMD ["app.py"]