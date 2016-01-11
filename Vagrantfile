Vagrant.configure(2) do |config|
  config.vm.box = "ethankhall/centos-6.5-java-mysql"
  config.vm.network "private_network", ip: "192.168.60.2"
  config.vm.synced_folder "~/.m2", "/home/vagrant/.m2"

  # config.vm.provision "shell",inline: "apt-get -y update"
  config.vm.provision "shell",path: "vagrant/mysql/install.sh", privileged: true
  config.vm.provision "shell", inline: "/sbin/service mysqld start", run: "always", privileged: true
end
