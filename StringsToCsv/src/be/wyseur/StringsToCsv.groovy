package be.wyseur

def separator = ";"
def file = new XmlParser().parse(new File("D:\\projects\\Git\\photoframeKobe\\PhotoFrame\\res\\values\\strings.xml"));
new File("keys.csv").withWriter { out ->
	out.writeLine "key" + separator + "en"
	file.string.each { 
		out.writeLine it.@name + separator + it.text()
	}
	file["string-array"].each{
		def arr = it.@name
		def i =0;
		it.item.each{
			out.writeLine arr + "." + (i++) + separator + it.text()
		}
	}
}