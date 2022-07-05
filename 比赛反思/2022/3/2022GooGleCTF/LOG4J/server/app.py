import os
import subprocess

from flask import Flask, render_template, request


app = Flask(__name__)

@app.route("/", methods=['GET', 'POST'])
def start():
    if request.method == 'POST':
        text = request.form['text'].split(' ')
        cmd = ''
        if len(text) < 1:
            return ('invalid message', 400)
        elif len(text) < 2:
            cmd = text[0]
            text = ''
        else:
            cmd, text = text[0], ' '.join(text[1:])
        result = chat(cmd, text)
        return result
    return render_template('index.html')

def chat(cmd, text):
    # run java jar with a 10 second timeout
    res = subprocess.run(['java', '-jar', '-Dcmd=' + cmd, 'chatbot/target/app-1.0-SNAPSHOT.jar', '--', text], capture_output=True, timeout=10)
    print(res.stderr.decode('utf8'))
    return res.stdout.decode('utf-8')

if __name__ == '__main__':
    port = os.environ['PORT'] if 'port' in os.environ else 1337
    app.run(host='0.0.0.0', port=port)
