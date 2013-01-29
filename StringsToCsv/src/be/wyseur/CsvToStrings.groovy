package be.wyseur

def lists = [:]
def outFiles = []

new File("iframe-strings.csv").splitEachLine(";") { fields ->
	if (fields[0]!='key'){
		if (fields[0].contains('.')){
			println("list " + fields[0])
			def key = fields[0].tokenize('.')[0]
			def pos = fields[0].tokenize('.')[1].toInteger()
			if (!lists[key]){
				lists[key] = []
			}
			println("item " + pos + " " + fields[2])
			while (lists[key].size() <= pos){
				lists[key].add([])
			}
			for (i in 1..(fields.size()-1)){
				//println(lists[key])
				//println(lists[key][pos])
				lists[key][pos].add(fields[i])
			}
		}else{
			if (fields.size() == 1){
				outFiles[1].write("\t<string name=\""+fields[0]+"\"> </string>\n");
			}else{
				for (i in 1..(fields.size()-1)){
					if (fields[i] && fields[i] != ''){
						outFiles[i].write("\t<string name=\""+fields[0]+"\">"+fields[i]+"</string>\n");
					}
				}
			}
		}
	}else{
		println("Init files");
		for (i in 1..(fields.size()-1)){
			if (fields[i] != ''){
				println("Init " + fields[i]);
				new File("values-" + fields[i]).mkdir()
				if (fields[i] == 'en'){
					outFiles[i]=new OutputStreamWriter(new FileOutputStream("C:\\dev\\git\\iframe\\res\\values/strings.xml"),"UTF-8");
				}else{
					outFiles[i]=new OutputStreamWriter(new FileOutputStream("C:\\dev\\git\\iframe\\res\\values-" + fields[i] + "/strings.xml"),"UTF-8");
				}
				outFiles[i].write("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n")
				outFiles[i].write("<resources>\n")
			}
		}
		//println("Lang1=" + fields[1])
		//println("Lang2=" + fields[2])
	}
}

lists.each {
	def key = it.key
	outFiles.each {
		if (it){
			it.write("\t<string-array name=\""+key+"\">\n")
		}
	}
	it.value.each{
		for (i in 1..(it.size())){
			outFiles[i].write("\t\t<item>"+it[i-1]+"</item>\n")
		}
	}
	outFiles.each {
		if (it){
			it.write("\t</string-array>\n")
		}
	}
}


outFiles.each {
	if (it){
		it.write("</resources>\n")
		it.close()
	}
}
