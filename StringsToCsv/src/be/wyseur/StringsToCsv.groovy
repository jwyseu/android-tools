package be.wyseur

def separator = ";"
def langs = []
def values = [:]

def folder = new File("D:\\projects\\Git\\iframe\\res\\")
folder.eachFile() { file->  
	if (file.name.startsWith("values")){
		def parts = file.name.tokenize('-')
		def lang = "en"
		if (parts.size() > 1){
			lang = parts[1]
		}
		println("Language " + lang)
		langs.add(lang)
		def xml = new XmlParser().parse(new File(file, "strings.xml"));
		xml.string.each {
			if (!values[it.@name]){
				values[it.@name] = []
			}
			values[it.@name].add(it.text())
		}
		xml["string-array"].each{
			def arr = it.@name
			def i =0;
			it.item.each{
				def key = arr + "." + (i++)
				if (!values[key]){
					values[key] = []
				}
				values[key].add(it.text())
			}
		}
	}
}  

new File("keys.csv").withWriter { out ->
	out.write "key" 
	langs.each{
		out.write separator + it
	}
	out.write "\n"
	values.each {
		out.write it.key
		it.value.each{
			out.write separator + it
		}
		out.write "\n"
	}
}