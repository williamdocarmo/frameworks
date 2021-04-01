<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns2="http://mdc.ericsson.com/ws/soap/"
	exclude-result-prefixes="ns">
	<xsl:template match="/">
		<ns2:userAuthenticationResponse xmlns:ns2="http://mdc.ericsson.com/ws/soap/">
			<ns2:responseHeader>
				<ns2:statusCode><xsl:value-of select = "//ns2:statusCode" /></ns2:statusCode>
				<ns2:statusMessage><xsl:value-of select = "//ns2:statusMessage" /></ns2:statusMessage>
				<ns2:source><xsl:value-of select = "//ns2:source" />_TRANSFORMED</ns2:source>
				<ns2:responseTime>Response time is: <xsl:value-of select = "//ns2:responseTime" /></ns2:responseTime>
			</ns2:responseHeader>
			<ns2:userAuthenticationData>
				<ns2:signum><xsl:value-of select = "//ns2:signum" /></ns2:signum>
				<ns2:password><xsl:value-of select = "//ns2:password" /></ns2:password>
				<ns2:role>
					<xsl:if test = "//ns2:role = 'Admin'">
						<xsl:text>Administrator</xsl:text>
					</xsl:if>
				</ns2:role>
			</ns2:userAuthenticationData>
		</ns2:userAuthenticationResponse>

	</xsl:template>
</xsl:stylesheet>
