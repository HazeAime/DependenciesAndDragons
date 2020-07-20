$(document).ready(function () {

    $('#signUpForm').on('submit', validatePassword);


    function validatePassword(event) {

        console.log('Running validation');

        let password = $(`#password`);
        let confirmPassword = $(`#confirmPassword`);

        if(password.val() != confirmPassword.val()) {
            confirmPassword[0].setCustomValidity('Passwords must be identical.');
            return false;
        } else {
            confirmPassword[0].setCustomValidity('');
            return true;
        }
    }
});
