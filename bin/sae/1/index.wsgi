﻿# -*- coding: utf-8 -*-
import sae
import sys
import urllib
import urllib2

reload(sys)
sys.setdefaultencoding('utf-8')

def app(environ, start_response):
    status = '200 OK'
    response_headers = [('Content-type', 'text/plain')]
    start_response(status, response_headers)
    sText="""
詹姆斯杜兰特韦德
"""
    sSinaServer='http://segment.sae.sina.com.cn/urlclient.php'
    payload = urllib.urlencode([('context', sText.encode('UTF-8')),])
    args = urllib.urlencode([('encoding', 'UTF-8'),])
    sUrl='?'.join([sSinaServer,args])
    Result=urllib2.urlopen(sUrl, payload).read() 
    return Result

application = sae.create_wsgi_app(app)