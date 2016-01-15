# Starts up a mysql instance
Vagrant.configure(2) do |config|
  config.vm.box = "ethankhall/centos-6.5-java-mysql"

  # Set the ip address
  config.vm.network "private_network", ip: "192.168.60.2"

  # Run mysql init once
  config.vm.provision "shell",path: "vagrant/mysql/install.sh", privileged: true
  
  # Start mysql every time the server start
  config.vm.provision "shell", inline: "/sbin/service mysqld start", run: "always", privileged: true
end
