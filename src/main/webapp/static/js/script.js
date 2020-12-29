document.querySelector('.img__btn').addEventListener('click', function() {
    document.querySelector('.content').classList.toggle('s--signup')
})
var na=document.getElementById('name_reg');
var nametip = document.getElementById("nametip");

var pawd =document.getElementById("pawd_reg");
var ruo=document.getElementById('ruo');
var zo=document.getElementById('zo');
var qiang=document.getElementById('qiang');
var pawdtip=document.getElementById("pawdtip");
var pwd = document.getElementById("pwd_reg");
var me;
var ph;
var ad;
var pd;
var psilde;


na.onblur=function(){
    //昵称正则表达式判断
  
    var reg = /^[\u2E80-\u9FFF,\w]{3,15}$/;//中文字符
    function z(re,e){//封装函数判断传入的数据
        if(e.value!=''){
            if(re.test(e.value)){
                e.nextSibling.src='..//img/d.svg';
                nametip.innerHTML = "";
                me=true;
            }
            else{
                e.nextSibling.src='../img/c.svg';
                nametip.style.color ="#f00";
                nametip.innerHTML = "3~15个中文字符或数字或字母组合";
                me=false;
            }
        }
        else{
            e.nextSibling.src='./images/c.svg';
            nametip.innerHTML = "不能为空";
            nametip.style.color ="#f00";
            me=false;
        }
    }
    z(reg,this);
}

pawd.onkeyup=function(){
        var regStr=/[a-zA-Z]/;//所有字母
        var regNum=/[0-9]/;//所有数字
        var sup=/\W/;//所有非字母数字
        if(this.value.length < 6){
            ruo.style.display="none";
            zo.style.display="none";
            qiang.style.display="none";
            pawdtip.innerHTML = "密码长度为6~16个字符!"
            pawdtip.style.color="red";
          
        }
        if(this.value.length>=6){
            pawdtip.innerHTML = "密码强度:"
            ruo.style.display="inline-block";
            ruo.className="ruo";
            ruo.innerHTML="弱";
          
            zo.className="";
           
            qiang.className="";
          
        }
        var sn=this.value.length>=6&&regStr.test(this.value)&&regNum.test(this.value);
        var sp=this.value.length>=6&&regStr.test(this.value)&&sup.test(this.value);
        var np=this.value.length>=6&&regNum.test(this.value)&&sup.test(this.value);
        if(sn||sp||np){
            zo.style.display="inline-block";
            ruo.className="zo";
            ruo.innerHTML="&nbsp;";
            zo.className="zo";
            zo.innerHTML="中";
           
        }
        if(this.value.length>=6&&regStr.test(this.value)&&regNum.test(this.value)&&sup.test(this.value)){
            ruo.className="qiang";
            ruo.innerHTML="&nbsp;";
            zo.className="qiang";
            zo.innerHTML="&nbsp;";
            qiang.className="qiang";
            qiang.style.display="inline-block";
            qiang.innerHTML="强";
          
        }
        if(this.value.length<6){
            ruo.style.display="none";
            zo.style.display="none";
            qiang.style.display="none";
        }
        if(this.value.length>16){
            ruo.style.display="none";
            zo.style.display="none";
            qiang.style.display="none";
            pawdtip.innerHTML = "密码长度为6~16个字符!"
            pawdtip.style.color="red";
        }
}
pwd.onblur=function(){//二次输入密码
    if(this.value!=''){
        if(this.value!=pawd.value){
            this.nextSibling.src='../img/c.svg';
                pwdtip.style.color ="#f00";
                pwdtip.innerHTML = "两次输入的密码不一致！";
        }
        else{
            this.nextSibling.src='../img/d.svg';
            
            ps[this.index].innerText="";
           
        }
    }else{
        this.nextSibling.src='../img/c.svg';
        pwdtip.style.color ="#f00";
        pwdtip.innerHTML = "不能为空！";
    }
}

var box=document.getElementById('verify_box');
var xbox=document.getElementById('verify_xbox');
var element=document.getElementById('btn2');
var d=document.querySelector('.verify');
var b=box.offsetWidth;
var o=element.offsetWidth;
element.ondragstart = function() {
    return false;
};
element.onselectstart = function() {
    return false;
};
element.onmousedown = function(e) {
    var disX = e.clientX - element.offsetLeft;
    document.onmousemove = function (e) {
        var l = e.clientX - disX +o;
        if(l<o){
            l=o
        }
        if(l>b){
            l=b
        }
        xbox.style.width = l + 'px';
    };
    document.onmouseup = function (e){
        var l = e.clientX - disX +o;
        if(l<b){
            l=o;
            d.nextElementSibling.innerText="验证失败";
            d.nextElementSibling.style.color="#f00";
           psilde = false;
        }else{
            l=b;
            xbox.innerHTML='<div id="btn2"><img style="margin-top:2px ;width:15px;height=15px;" class="img1" src="../img/c.svg"/></div>';
            d.nextElementSibling.innerText="验证通过";
            d.style.border='none';
            d.nextElementSibling.style.color="#090";
            psilde = true;
        }
        xbox.style.width = l + 'px';
        document.onmousemove = null;
        document.onmouseup = null;
    };
}
window.onload = function(){
    change();
    change1();
}
function change() {
    code=document.getElementById("code");
    // 验证码组成库
    var arrays = new Array(
            '1','2','3','4','5','6','7','8','9','0',
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T',
            'U','V','W','X','Y','Z'
    );
    codes='';// 重新初始化验证码
    for(var i = 0; i<4; i++){
        // 随机获取一个数组的下标
        var r = parseInt(Math.random()*arrays.length);
        codes += arrays[r];
    }
    // 验证码添加到input里
    code.value = codes;
}
function change1() {
    code=document.getElementById("code1");
    // 验证码组成库
    var arrays = new Array(
            '1','2','3','4','5','6','7','8','9','0',
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T',
            'U','V','W','X','Y','Z'
    );
    codes='';// 重新初始化验证码
    for(var i = 0; i<4; i++){
        // 随机获取一个数组的下标
        var r = parseInt(Math.random()*arrays.length);
        codes += arrays[r];
    }
    // 验证码添加到input里
    code.value = codes;
}
