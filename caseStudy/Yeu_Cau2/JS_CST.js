function sendinfor() {
    let infor  = document.getElementById('infor');
    let giaDichvu = parseInt(infor.room.value);
    let rentDay = parseInt(infor.date.value);
    let sale = parseInt(infor.sale.value);
    let money = giaDichvu * rentDay * (1 - sale/100);
    document.write("Họ và tên: " + infor.fullname.value + "<br>");
    document.write("Số CMND: " + infor.number.value  + "<br>" );
    document.write("Ngày sinh: " + infor.birthDay.value  + "<br>" );
    document.write("Email: " + infor.email.value  + "<br>" );
    document.write("Địa chỉ: " + infor.address.value  + "<br>");
    document.write("Loại Customer: " + infor.member.value  + "<br>");
    document.write("Giảm giá: " + infor.sale.value + "%"  + "<br>");
    document.write("Số người đi cùng: " + infor.human.value  + "<br>");
    document.write("Số ngày thuê: " + infor.date.value  + "<br>");
    document.write("Loại dịch vụ: " + infor.room.value  + "<br>");
    document.write("Số tiền phải trả =" + money);

}
