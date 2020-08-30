class Computer:

    def __init__(self, cpu, gpu, ram, ssd):
        self.cpu = cpu
        self.gpu = gpu
        self.ram = ram
        self.ssd = ssd
    
    def createComputer(self):
        print("----Creating Computer with below Configuration----")
        print("CPU:", self.cpu)
        print("GPU:", self.gpu)
        print("RAM:", self.ram)
        print("SSD:", self.ssd)