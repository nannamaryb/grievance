document.querySelector("#pdf-upload").addEventListener("change", function(e){
	var canvasElement = document.querySelector("canvas")
	var file = e.target.files[0]
	if(file.type != "application/pdf"){
		console.error(file.name, "is not a pdf file.")
		return
	}
	
	var fileReader = new FileReader();  

	fileReader.onload = async (result) => {
		var typeArray = new Uint8Array(result.target.result);
		const pdf = await PDFJS.getDocument(typeArray)
		// you can now use *pdf* here
		console.log("the pdf has a ",pdf.numPages, "page(s).")
		const page = await pdf.getPage(pdf.numPages)
		// you can now use *page* here
		var viewport = page.getViewport(2.0);
		var canvas = document.querySelector("canvas")
		canvas.height = viewport.height;
		canvas.width = viewport.width;

		page.render({
			canvasContext: canvas.getContext('2d'),
			viewport: viewport
		});
	};

	fileReader.readAsArrayBuffer(file);
})