package be.wyseur

println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>")
println("<resources>")

def lists = [:]

new File("keys-cz.csv").splitEachLine(";") { fields ->
	if (fields[0]!='key'){
		if (fields[0].contains('.')){
			//println("list " + fields[0])
			def key = fields[0].tokenize('.')[0]
			def pos = fields[0].tokenize('.')[1].toInteger()
			if (!lists[key]){
				lists[key] = [""]
		}
			//println("item " + pos + " " + fields[2])
			if (lists[key].size() > pos){
				lists[key].set(pos, fields[2])
			}else{
				while (lists[key].size() < pos){
					lists[key].add("")
				}
				lists[key].add(fields[2])
			}
		}else{
			println("\t<string name=\""+fields[0]+"\">"+fields[2]+"</string>")
		}
	}else{
		//println("Lang1=" + fields[1])
		//println("Lang2=" + fields[2])
	}
}

lists.each {
	println("\t<string-array name=\""+it.key+"\">")
	it.value.each{
		println("\t\t<item>"+it+"</item>")
	}
	println("\t</string-array>")
}
println("</resources>")