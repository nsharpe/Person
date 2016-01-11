# Setup firewall
iptables -P INPUT ACCEPT
iptables -F
iptables -A INPUT -i lo -j ACCEPT
iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT
iptables -A INPUT -p tcp --dport 22 -j ACCEPT
iptables -A INPUT -p tcp --dport 3306 -j ACCEPT
iptables -P INPUT DROP
iptables -P FORWARD DROP
iptables -P OUTPUT ACCEPT
iptables -A INPUT -i lo -j ACCEPT
iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT

service iptables save

echo "Setting mysql configuration"
sed -i "s/.*bind-address.*/# bind-address = 0.0.0.0/" /etc/my.cnf
sed -i "s/skip-external-locking/# skip-external-locking/" /etc/my.cnf

echo 'bind-address = 0.0.0.0' >> /etc/my.cnf
echo 'port = 3306' >> /etc/my.cnf

/sbin/service mysqld start

echo "Updating user rights and creating database person"
mysql -u root < /vagrant/vagrant/mysql/init.sql
mysql -u root < /vagrant/src/main/resources/database-create.sql

/sbin/service mysqld stop

