package be.wyseur

def separator = ";"
def file = new XmlParser().parse(new File("D:\\projects\\Git\\photoframeKobe\\PhotoFrame\\res\\values\\strings.xml"));

println("key\ten");
file.string.each { 
	println it.@name + separator + it.text()
}
file["string-array"].each{
	def arr = it.@name
	def i =0;
	it.item.each{
		println(arr + "." + (i++) + separator + it.text())
	}
}