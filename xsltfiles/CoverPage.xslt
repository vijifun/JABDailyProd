<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy� -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/> 
<xsl:template match="/">
<html>
  <title>HTML REPORTING</title>
     <body>
        <h1 align="center"><xsl:value-of select="//ProjectName"/></h1>
	<table  align="center" width="100%">
<tr>
<td align="left" width="50%"><a href="https://www.josbank.com"><IMG ALIGN="left" ALT="client" SRC="..\Logos\TMW.jpg"></IMG></a></td>
<td align="right" width="50%"><a href="http://www.indiumsoft.com"><IMG SRC="..\Logos\Indium-Software-Logo.jpg" ALT="Indium Logo" ALIGN="Right"></IMG></a></td>
</tr>
</table>
<br>
</br>
	<table align="left">
	<tr>
    	<td><b>DATE:-</b></td>
    	<td ><xsl:value-of select="//Date"/></td>
	</tr>
	
	<tr>
    	<td><b>DURATION:-</b></td>
    	<xsl:choose>
    	<xsl:when test="round(//test/@total div 1000) div 60>'59'">
    	<td><xsl:value-of select="round(round((//test/@total div 1000) div 60)div 60)"/><xsl:text>hr:</xsl:text><xsl:value-of select="round((//test/@total div 1000) div 60)mod 60"/><xsl:text>min:</xsl:text><xsl:value-of select="round((//test/@total div 1000) div 60)mod 60"/><xsl:text>sec</xsl:text></td>
	</xsl:when>
    	<xsl:when test="round(//test/@total div 1000) div 60>'1'">
    	<td><xsl:value-of select="round((//test/@total div 1000) div 60)"/><xsl:text> Min:</xsl:text><xsl:value-of select="round((//test/@total div 1000) mod 60)"/><xsl:text>Sec</xsl:text></td>
	</xsl:when>
	<xsl:otherwise>
    	<td><xsl:value-of select="round((//test/@total div 1000))"/><xsl:text> Seconds</xsl:text></td>
	</xsl:otherwise>
	</xsl:choose>
	</tr>
	<tr>
	<td><b>Build No:-</b></td>
	<td><xsl:value-of select="//VersionName"/></td>
	</tr>
	</table>
	<table align="right">
	<tr>
    	<td><b>Machine Name:-</b></td>
    	<td ><xsl:value-of select="//test//before-method/params/param[@index=0]/value"/></td>
	</tr>
	
	<tr>
    	<td><b>Operating System:-</b></td>
    	<td ><xsl:value-of select="//test//before-method/params/param[@index=4]/value"/>-<xsl:value-of select="//test//before-method/params/param[@index=6]/value"/></td>
	</tr>
	<tr>
	<td><b>Browser:-</b></td>
		<td ><xsl:value-of select="//test//before-method/params/param[@index=3]/value"/>-<xsl:value-of select="//test//before-method/params/param[@index=5]/value"/></td>
	</tr>
	</table>
	<br><br><br></br></br></br>
	<TABLE border="1"> 
	<TR> 
	<TD colspan="4"><center><b>Test Case Execution status</b></center></TD> 
	</TR> 
	<TR> 
	<TD><b>EXECUTED</b></TD> 
	<TD><b>PASSED</b></TD> 
	<TD><b>FAILED</b></TD> 
	<TD><b>SKIPPED</b></TD>
	</TR>
	<TR>
	<TD><xsl:value-of select="//test/@totalTest"/></TD> 
	<TD><xsl:value-of select="//test/@totalPassed"/></TD> 
	<TD><xsl:value-of select="//test/@totalFailed"/></TD> 
	<TD><xsl:value-of select="//test/@totalSkipped"/></TD>
	</TR>
	<TR>
	<TD><center><b>Percentage</b></center></TD> 
	<TD><xsl:value-of select="round(//test/@totalPassed div //test/@totalTest*100)"/><xsl:text>%</xsl:text></TD> 
	<TD><xsl:value-of select="round(//test/@totalFailed div //test/@totalTest*100)"/><xsl:text>%</xsl:text></TD> 
	<TD><xsl:value-of select="round(//test/@totalSkipped div //test/@totalTest*100)"/><xsl:text>%</xsl:text></TD>
	</TR>
	</TABLE>
	<br></br>
	<a href=".\SummaryPage.html">Click here to see the summary report</a>
	<br></br>
	<a href=".\..\GridReport.html">Click here to see the grid report</a>
     </body>
</html>
</xsl:template>
</xsl:stylesheet>

