<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output indent="yes" />
	<xsl:strip-space elements="*" />

	<xsl:variable name="contadorErrores" select="substring(trama,59,2)" />

	<xsl:variable name="listadoErrores">
		<xsl:call-template name="tokenizeError">
			<xsl:with-param name="input" select="substring(trama,61)" />
			<xsl:with-param name="length" select="84" />
		</xsl:call-template>
	</xsl:variable>

	<xsl:template match="/">
		<xsl:choose>
			<xsl:when test="contains(trama,'IOCXXXX01O')">
				<crearResponse>
					<formato>
						<xsl:value-of select="normalize-space(substring(trama,1,10))" />
					</formato>
					<codRespuesta>
						<xsl:value-of select="normalize-space(substring(.,11,4))" />
					</codRespuesta>
					<descripcion>
						<xsl:value-of select="normalize-space(substring(.,15,60))" />
					</descripcion>
				</crearResponse>
			</xsl:when>
			<xsl:when test="contains(trama,'ECNLERR   ')">
				<crearResponse>
					<error>
						<formato>
							<xsl:value-of select="normalize-space(substring(trama,1,10))" />
						</formato>
						<identificador>
							<xsl:value-of select="normalize-space(substring(trama,11,24))" />
						</identificador>
						<correlativo>
							<xsl:value-of select="normalize-space(substring(trama,35,24))" />
						</correlativo>
						<numeroErrores>
							<xsl:value-of select="number(substring(trama,59,2))" />
						</numeroErrores>
						<errores>
							<xsl:for-each
								select="$listadoErrores/Errores[(position()&lt;number($contadorErrores)+1)]">
								<detalleError>
									<codigo>
										<xsl:value-of select="number(substring(.,1,4))" />
									</codigo>
									<descripcion>
										<xsl:value-of select="normalize-space(substring(.,5,80))" />
									</descripcion>
									<origen>crearResponse</origen>
								</detalleError>
							</xsl:for-each>
						</errores>
					</error>
				</crearResponse>
			</xsl:when>
			<xsl:otherwise>
				<crearResponse>
					<error>
						<formato>Internal</formato>
						<numeroErrores>1</numeroErrores>
						<errores>
							<detalleError>
								<codigo>513</codigo>
								<descripcion>Error no identificado al tratar de interpretar los
									datos.
								</descripcion>
								<origen>Internal Server Error</origen>
							</detalleError>
						</errores>
					</error>
				</crearResponse>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template name="tokenizeError">
		<xsl:param name="input" />
		<xsl:param name="length" />
		<Errores>
			<xsl:value-of select="substring($input,1,$length)" />
		</Errores>
		<xsl:if test="substring($input,$length+1)">
			<xsl:call-template name="tokenizeError">
				<xsl:with-param name="input" select="substring($input,$length+1)" />
				<xsl:with-param name="length" select="$length" />
			</xsl:call-template>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
