#https://hub.docker.com/r/socialengine/php-apache/
#http://www.phprs.com.br/2016/05/criando-um-ambiente-de-desenvolvimento-php-com-docker-compose/
FROM php:7.1-apache
RUN apt-get update && apt-get install -y \
            libfreetype6-dev \
            libjpeg62-turbo-dev \
            libpng12-dev \
            libpq-dev \
            libpcre3-dev && \
    docker-php-ext-configure gd --with-freetype-dir=/usr/include/ --with-jpeg-dir=/usr/include/ && \
    docker-php-ext-install gd && \
    docker-php-ext-install pgsql && \
    docker-php-ext-install pdo_pgsql && \
    pecl install apcu-5.1.7 && \
    docker-php-ext-enable apcu && \
    apt-get autoremove -y && \
    rm -rf /var/lib/apt/lists/* && \
    a2enmod rewrite

COPY php.ini /usr/local/etc/php/
