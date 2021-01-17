FROM postgres:11.5

RUN apt-get update;
RUN apt-get install -y postgresql-client-11 
RUN apt-get install -y postgresql-common
RUN apt-get install -y postgresql-11 
RUN apt-get install -y postgresql-11-postgis-2.5 
RUN apt-get install -y postgresql-11-pgrouting 
RUN apt-get install -y netcat
RUN apt-get install -y postgresql-11-ogr-fdw

RUN apt-get update && \
      apt-get -y install sudo