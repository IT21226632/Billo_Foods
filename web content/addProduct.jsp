<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addProduct</title>

<style type="text/css">

body{

background-image : url("Images/foodimage4.png");
	background-size : cover;
	background-repeat : no-repeat;
	
	
}


.add-card{
    background-color: transparent;
    margin: auto; 
    width: 40%;
    padding: 5px;
    flex-direction: row;
    border-radius: 15px;
    position: absolute;
    right : 50px;
}

.image-col{
    width: 30%;
    padding-top: 10px;
     
}
.pre-product{ 
    width: 300px;
    justify-content : center;
}
.custom-file-input {
  color: transparent; 
  width: 150px;
  margin-top: 20px;
}
.custom-file-input::-webkit-file-upload-button {
  visibility: hidden;
  font-size: 20px;
}
.custom-file-input::before {
  content: 'Change';
  color: #F5DEB3;
  display: inline-block; 
  padding: 5px 5px;
  outline: none;
  white-space: nowrap;
  -webkit-user-select: none;
  cursor: pointer;
  text-shadow: 1px 1px #fff;
  font-weight: 700;
  font-size: 16pt;
}
.custom-file-input:hover::before {
  border-color: #F5DEB3;
}
.custom-file-input:active {
  outline: 0;
}
.custom-file-input:active::before {
 }
 .input-row{
    display: flex;
    flex-direction: column;
    margin-top: 20px;
 } 
 .btn-row{
    display: flex;
    flex-direction: row;
    margin-top: 20px;
    justify-content: end;
 }
 .error-txt{
     color: rgb(214, 50, 50);
     font-size: 15px;
 }
 .input{
     padding: 10px 15px;
     margin-top: 10px;
     margin-bottom: 5px;
 }
 .btn-save{
     background-color: #FFFACD;
     border: 0px;
     font-size: 20px;
     cursor: pointer;
     margin-right: 20px;
     color: rgb(32, 158, 74);
     border-radius: 15px;
 }

 .btn-cancel{
     background-color: #FFFACD;
     border: 0px;
     cursor: pointer;
     font-size: 18px;
     color: rgb(22, 22, 22);
     border-radius: 15px;
 }


/* Hide the images by default */
.mySlides {
  display: none;
}
 
</style>

</head>
<body >




<div class="container"> 
						
                          
                <div class="row add-card ">
                    <form action="p2" method="post" enctype = "multipart/form-data">
                    <fieldset>
                 				<legend><font color="#F5DEB3" size = "6px">Add Product</font></legend> 
                        <div class="row">
                            <div class="col-5 image-col">
                            
                                <font color="#F5DEB3" size = "3px">Product Image</font> :
                                <img class="pre-product" id="pre-product" src="Images/img-preview.png">
                                <input type="file" class="custom-file-input" name="image" id="image" required/>
                            </div>
                            
                            <div class="col-5">
                                <div class="input-row">
                                    <label for="name" ><font color="#F5DEB3" size = "3px">Product Name</font></label>
                                    <input type="text" class="input" name="name" id="name" placeholder="Enter Product name" required>
                                    <span class="error-txt" id="error-name"></span>
                                </div>
                                
                                <div class="input-row">
                                    <label for="price"> <font color="#F5DEB3" size = "3px">	Product price</font></label>
                                    <input type="number" min="0" class="input" name="price" id="price" placeholder="Enter Product price" required>
                                    <span class="error-txt" id="error-price"></span>
                                </div>
                                
                                <div class="input-row">
                                    <label for="qty"><font color="#F5DEB3" size = "3px">Product Code</font></label>
                                    <input type="number" min="0" class="input" name="code" id="qty" placeholder="Enter Product Code" required>
                                    <span class="error-txt" id="error-qty"></span>
                                </div>
                                                              
                                    <span class="error-txt" id="error-category"></span>
                                </div>
                                <div class="input-row">
                                    <label for="dec"><font color="#F5DEB3" size = "3px">Product description</font></label>
                                    <textarea class="input" name="dec" id="dec" placeholder="Enter Product description" required></textarea>
                                    <span class="error-txt" id="error-dec"></span>
                                </div>
                                <div class="btn-row">
                                   <button class="btn-save" type="submit"  >Save</button>                                   
                                   <button class="btn-cancel"type="reset" >Cancel</button>
                                </div>
                                
                            </div>
                            </fieldset>                     
                    </form>
                </div>              
            </div> 

   
         <script>
        document.getElementById('image').onchange = function (evt) {
            var tgt = evt.target || window.event.srcElement,
                files = tgt.files;
 
            if (FileReader && files && files.length) {
                var fr = new FileReader();
                fr.onload = function () {
                    document.getElementById("pre-product").src = fr.result;
                }
                fr.readAsDataURL(files[0]);
            }

             
            else {
                document.getElementById("error-img").innerHTML = "Can not preview the image";
            }
        }
    </script>

</body>
</html>