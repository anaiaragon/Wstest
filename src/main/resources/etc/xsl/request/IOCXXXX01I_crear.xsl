<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" omit-xml-declaration="no" indent="no" />
	<xsl:variable name="fixedData" />
	<xsl:strip-space elements="*" />
	<xsl:template match="*">

		<H01FMTNME>IOCXXXX01I</H01FMTNME>
		<H01USERID>
			<xsl:call-template name="espaciosDer">
				<xsl:with-param name="data" select="userId" />
				<xsl:with-param name="largo" select="string(10)" />
			</xsl:call-template>
		</H01USERID>
		<H01CODBNK>01</H01CODBNK>
		<H01CODTRN>XXXX</H01CODTRN>
		<H01CODCNL>0005</H01CODCNL>
		<H01CODOPE>0001</H01CODOPE>
		<H01CODCAN>
			<xsl:call-template name="espaciosDer">
				<xsl:with-param name="data" select="canalLlamada" />
				<xsl:with-param name="largo" select="string(4)" />
			</xsl:call-template>
		</H01CODCAN>
	</xsl:template>

	<!-- Definicion De funciones de Relleno And Padding -->
	<xsl:template name="cerosIzq">
		<xsl:param name="data" />
		<xsl:param name="largo" />
		<xsl:variable name="relleno"
			select="string('0000000000000000000000000000000000000000000000000000000000')" />
		<xsl:variable name="rellenoData" select="concat($relleno,$data)" />
		<xsl:value-of
			select="substring($rellenoData,string-length($rellenoData)-$largo+1,$largo)" />
	</xsl:template>

	<xsl:template name="espaciosIzq">
		<xsl:param name="data" />
		<xsl:param name="largo" />
		<xsl:variable name="relleno"
			select="string('                                                           ')" />
		<xsl:variable name="rellenoData" select="concat($relleno,$data)" />
		<xsl:value-of
			select="substring($rellenoData,string-length($rellenoData)-$largo+1,$largo)" />
	</xsl:template>

	<xsl:template name="espaciosDer">
		<xsl:param name="data" />
		<xsl:param name="largo" />
		<xsl:variable name="relleno"
			select="string('                                                           ')" />
		<xsl:variable name="rellenoData" select="concat($data, $relleno)" />
		<xsl:value-of select="substring($rellenoData,1,$largo)" />
	</xsl:template>

</xsl:stylesheet>