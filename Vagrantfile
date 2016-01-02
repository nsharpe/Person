Vagrant.configure(2) do |config|
  config.vm.box = "hashicorp/precise32"
  config.vm.network "private_network", ip: "192.168.60.2"
  config.vm.synced_folder "~/.m2", "/home/vagrant/.m2"

  config.vm.provision "shell",inline: "apt-get -y update"
  config.vm.provision "shell",path: "vagrant/mysql/install-and-start.sh"
end
