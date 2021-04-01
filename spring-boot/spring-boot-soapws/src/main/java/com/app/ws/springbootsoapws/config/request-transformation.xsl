<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:soap="http://mdc.ericsson.com/ws/soap/"
	exclude-result-prefixes="ns">
	<xsl:template match="/">
		<soap:userAuthenticationRequest>
			<soap:requestHeader>
				<soap:sourceSystem>Transformed Source is <xsl:value-of select="//soap:sourceSystem" /> </soap:sourceSystem>
				<soap:timestamp><xsl:value-of select="//soap:timestamp" /> PM</soap:timestamp>
			</soap:requestHeader>
			<soap:signum>T<xsl:value-of select="//soap:signum" /></soap:signum>
		</soap:userAuthenticationRequest>
	</xsl:template>
</xsl:stylesheet>
