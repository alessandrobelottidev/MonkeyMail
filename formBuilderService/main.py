import uvicorn
from fastapi import Request, FastAPI

app = FastAPI()

def create_html_input(name, html_type, placeholder, required, label, description):
    annotation = ""
    if required:
        annotation = "*"

    html_input = f"""
    <div class='mm-form-group'>
        <label class='mm-form-label' for='{name}'>{label} <span>{annotation}</span></label>
        <input type='{html_type}' class='mm-form-control' id='mm-{name}' name='{name}' placeholder='{placeholder}' required='{required}'>
    """

    if description:
        html_input += f"""
        <p id='mm-{name}-help' class='mm-form-help-text'>{description}</p>
        """

    html_input += "</div>"

    return html_input


@app.post("/generateForm")
async def generate_form(request: Request):
    body = await request.json()

    html_inputs = ""

    # Loop through the fields and create the html inputs
    for field in body["fields"]:
        html_inputs += create_html_input(field["name"], field["type"], field["placeholder"], field["required"],
                                         field["label"], field["description"])

    # Load css from configuration files
    monkey_mail_css = ""

    with open("./styles/monkey_mail_normalize.css", "r") as f:
        monkey_mail_css += f.read()

    with open("./styles/monkey_mail_custom_form.css", "r") as f:
        monkey_mail_css += f.read()

    css = f"<style>{monkey_mail_css}</style>"

    html = f"""
    {css}
    <form class='mm-form' action='' method='GET'>
    <h3 class='mm-form-title'>{body["title"]}</h3>
    {html_inputs}
    <button type='submit' class='mm-form-submit'>{body["submit"]["value"]}</button>
    </form>
    """.replace('\n', ' ').replace('\r', '').replace("\t", '').replace("  ", '').replace("         ", "")

    return html


if __name__ == '__main__':
    uvicorn.run('main:app', port=8000, reload=True)
