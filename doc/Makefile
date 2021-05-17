
%.html: %.adoc
		asciidoctor -b html5 -a linkcss -a imagesdir=images -a stylesdir=css -a stylesheet=asciidoctor.css $<

all: SetupLayeredArchitecture.html revisedarchitecture.html

SetupLayeredArchitecture.html: SetupLayeredArchitecture.adoc images/*.svg

revisedarchitecture.html :revisedarchitecture.adoc images/*.svg

clean:
	rm -f SetupLayeredArchitecture.html
