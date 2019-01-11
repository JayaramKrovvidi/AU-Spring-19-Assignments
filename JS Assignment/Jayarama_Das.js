//-------Calling------

function Employee(id, name, age)
{
  this.id=id;
  this.name=name;
  this.age=age;
}

var e1=new Employee(001,"jay","21");
console.log(e1);

function IT(id,ename,age) {
  Employee.call(this,id,ename,age);
  this.salary="60000"
  this.activities="debugging"
}

console.log(new IT(12,'IT1',20));

function hr(id,ename,age) {
  Employee.call(this,id,ename,age);
  this.activities="appraisals"
  this.leaves="none";
}

console.log(new hr(13,'HR1',20));

hr.prototype.Gender="Male";
console.log(new hr(15,'zxy',90).Gender);

//------Binding-------------

let new_employee={
  id:10,
  name:"xyz",
  age:20 
};

let security={
  name:"abc",
  id:235,
  salary : 10000,
  gender:"Male"
};

function details(){
  console.log(this.id+'  '+this.name+' '+this.age);
}

function additionals(){
  this.salary+=20000
  console.log(this.salary);
}

  let emp_details=details.bind(new_employee);
  emp_details();
  
  let add_security=additionals.bind(security);
  add_security();