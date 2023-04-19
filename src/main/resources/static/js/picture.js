<!--                has to be form
        input type=file name =file
        file response client.upload
&ndash;&gt;-->
<!--preview tag img src:=${fileUrlsa} -->

const file = document.getElementById('file');
const upload = document.getElementById('upload');
const status = document.getElementById(status);

upload.addEventListener('click', () => {
    // set status to uploading
    status.innerHTML = 'uploading…';

    const fileReader = new FileReader();
    fileReader.readAsArrayBuffer(file.files[0]);


    fileReader.onload = (event) => {
        console.log('Complete File read successfully!')
    }
});