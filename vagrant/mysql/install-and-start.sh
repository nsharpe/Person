
# Set password
debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password password root'
debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password_again password root'

#Install mysql
apt-get -y install mysql-server-5.5 mysql-client

echo "Updating user rights and creating database person"
mysql -u root --password=root < /vagrant/vagrant/mysql/init.sql
mysql -u root --password=root < /vagrant/src/main/resources/database-create.sql

echo "Setting mysql configuration"
sed -i "s/.*bind-address.*/bind-address = 0.0.0.0/" /etc/mysql/my.cnf
sed -i "s/skip-external-locking/# skip-external-locking/" /etc/mysql/my.cnf

service mysql restart
