//REDIRECT TO LOGIN IF USER IS NOT LOGGED IN
function checkforlogin(){
  if(!localStorage.getItem('currentUserId')){
    window.location = './login.html'
  }
}


//GET LOGIN FORM DATA
function log(){
    let username = document.getElementById('Username').value;
    let password = document.getElementById('Password').value;
    //getBalance(username,password);
    login(username,password);
}

//PERFORM LOGIN
async function login(username,password){
  const data = { username: username,password:password };
  await fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response =>response.json())
  .then(resdata => {
    console.log(resdata)
    localStorage.setItem("currentUserId",resdata);
    window.location = './viewbalance.html';

  })
  .catch((error) => {
    console.error('Error:', error);
  });
}


//GET BALANCE
async function getBalance(username,password){
    const id = localStorage.getItem("currentUserId");
    if(id){

      await fetch('http://localhost:8080/balance', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(id),
      })
      .then(response =>response.json())
      .then(resdata => {
        console.log(resdata)
        document.getElementById('balancediv').style.display= 'block'; 
        document.getElementById("showBalanceHere").innerHTML = resdata;
  
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    }
    else{
      console.log("Please Login");
    }
}


//GET TRANSFER FORM DATA
function transferData(){
    let sid = localStorage.getItem('currentUserId');
    let rid = document.getElementById('rid').value;
    let amount = document.getElementById('amount').value;

    if(!isNaN(sid) && !isNaN(rid) && !isNaN(amount) ){
      trasnferMoney(sid,rid,amount);
    }
    else{
      alert("Please Enter valid values");
    }
}

//PERFORM TRANSFER FROM SENDERID TO RECIEVERID
async function trasnferMoney(sid,rid,amount){
  const data = { senderid: sid,recieverid:rid,amount:amount };

  await  fetch('http://localhost:8080/transfer', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
    .then(response => 
      response.json()
    )
    .then(resdata => {
      console.log(resdata)
      let result = `Transferred ${amount} from ${resdata.senderName}(Balance ${resdata.senderBalance}) to ${resdata.recieverName}(Balance ${resdata.recieverBalance})`;
      document.getElementById("showTransferBalanceHere").innerHTML = result
    })
    .catch((error) => {
      console.error('Error:', error);
    });

}



//GET REGISTER FORM DATA
function getregisterdata(){
  let username = document.getElementById('Username').value;
  let password = document.getElementById('Password').value;
  let repassword = document.getElementById('rePassword').value;
  
  if(password !== repassword){
    alert("Passwords didnt match")
    password.value='';
    document.getElementById('Password').value = '';
    document.getElementById('rePassword').value = '';
      
  }
  else{
    register(username,password);
  }
}

//POST REQUEST TO CREATE USER IN DATABASE
async function register(username,password){

  const data = { username: username,password:password};

  await  fetch('http://localhost:8080/register/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
    .then(response => 
      response.json()
    )
    .then(resdata => {
      if(resdata.success===1){
        document.getElementById('showResponseHere').innerHTML = `<h1>Account Creation Successful.Please Login.</h1>`;
        document.getElementById('Username').value='';
        document.getElementById('Password').value='';
        document.getElementById('rePassword').value='';
        window.location = './login.html';
      }
      console.log("Account Created");
    })
    .catch((error) => {
      console.error('Error:', error);
    });

}

//LOGOUT FUNCTION
function logout(){
  localStorage.clear();
  window.location = 'login.html';
}

//SET SENDER ID FIELD AND DISABLE IT
function setSenderAccountId(){
  if (localStorage.getItem('currentUserId')) {
    document.getElementById('Username').value = localStorage.getItem('currentUserId');
  }
  else{
    window.location ='./login.html'
  }
}