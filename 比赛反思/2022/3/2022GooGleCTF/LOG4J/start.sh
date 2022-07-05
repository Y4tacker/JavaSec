#!/bin/bash
BINDPORT="${PORT:-1337}" 
gunicorn -b 0.0.0.0:$BINDPORT -w 4 app:app
