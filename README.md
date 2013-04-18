android-tools
=============
Tools for internationalization and icon/launcher creation. 

This repository contains some scripts or code I use when developing android applications. In making this available, I hope other people can make use of this. It does not contain finished and polished software only some usable bits.

Localization
============
Because translation are often done by another party, a conversion from the different strings.xml files to csv which can be edited in any spreadsheet tool is very useful. Business users tend to not like the XML format very much. The eclipse project contains two groovy scripts. These can be used outside of eclipse also. StringsToCsv does the conversion from the strings.xml to csv. Change the folder location in the script to the res folder of your project. CsvToStrings does the conversion in the other direction. Just specify the location of the csv. You can also add new columns, just add the language key in the header and start translating.

Inkscape automation
===================
The icons I use in my android apps I make (or copy from free sites and adapt) with inkscape in svg format. This makes sure it looks good in every resolution. The conversion to the different sizes in png can be scripted.
* Icon creation : creates an ldpi, mdpi and hdpi version of the svg icon in the right folders. 
* Launcher creation : creates an ldpi, mdpi, hdpi and xhdpi version of the svg icon in the right folders. It also creates a 512x512 png to be used in the market. 
